/**
 * Copyright 2017, 2018, 2019, 2020 Stephen Powis https://github.com/Crim/pardot-java-client
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit
 * persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.darksci.pardot.api.response;

import com.darksci.pardot.api.InvalidRequestException;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Represents either a successful response from the API, or an error response.
 * @param <T> The return type for successful responses.
 */
public class Result<T> {
    private final T value;
    private final ErrorResponse errorResponse;

    /**
     * Private constructor.  Use factory methods.  {@link Result#newSuccess} {@link Result#newFailure}
     * @param response Success result object.
     * @param errorResponse error result.
     */
    private Result(final T response, final ErrorResponse errorResponse) {
        if (response != null && errorResponse != null) {
            throw new IllegalArgumentException("You may not pass both parameters as non-null");
        } else if (response == null && errorResponse == null) {
            throw new IllegalArgumentException("You may not pass both parameters as null");
        }

        this.value = response;
        this.errorResponse = errorResponse;
    }

    /**
     * Factory method for when there is a successful response.
     * @param response Response object.
     * @param <T> Type of the response object.
     * @return new ResultOrError instance.
     */
    public static <T> Result<T> newSuccess(final T response) {
        return new Result<>(Objects.requireNonNull(response), null);
    }

    /**
     * Factory method for when there is an error returned from the API.
     * @param errorResponse ErrorResponse object.
     * @param <T> Type of the response object.
     * @return new ResultOrError instance.
     */
    public static <T> Result<T> newFailure(final ErrorResponse errorResponse) {
        return new Result<>(null, Objects.requireNonNull(errorResponse));
    }

    /**
     * If a response from the API is present, returns the value, otherwise throws
     * {@code NoSuchElementException}.
     *
     * @return the non-{@code null} value described by this {@code Optional}
     * @throws NoSuchElementException if no success response is present
     * @see Result#isSuccess()
     */
    public T get() {
        if (!isSuccess()) {
            throw new NoSuchElementException("Cannot access response as there was an error");
        }
        return value;
    }

    /**
     * If an error response from the API is present, return the error response.
     * Otherwise throws {@code NoSuchElementException}.
     * @return ErrorResponse from API.
     * @throws NoSuchElementException if no error response is present.
     * @see Result#isFailure() ()
     */
    public ErrorResponse getFailure() {
        if (isSuccess()) {
            throw new NoSuchElementException("Cannot access response as there was an error");
        }
        return errorResponse;
    }

    /**
     * Return {@code true} if there is a successful result from the API present, otherwise {@code false}.
     *
     * @return {@code true} if there is a value present, otherwise {@code false}
     */
    public boolean isSuccess() {
        return value != null;
    }

    /**
     * Return {@code true} if there is a failure result from the API present, otherwise {@code false}.
     *
     * @return {@code true} if there is a value present, otherwise {@code false}
     */
    public boolean isFailure() {
        return !isSuccess();
    }

    /**
     * Returns the success value if present, otherwise returns the default value.
     * @param defaultValue value to be returned if no success value is present.
     * @return Success value if present, otherwise returns the default value.
     */
    public T getOrDefault(final T defaultValue) {
        if (isSuccess()) {
            return get();
        }
        return defaultValue;
    }

    /**
     * For handling response values.
     *
     * @param successConsumer called if there is a successful response.
     * @param errorResponseConsumer called if there is an error response.
     * @return On success, call and return value from success handler.  On error, call and return value from error handler.
     */
    public T handle(final Function<? super T, T> successConsumer, final Function<ErrorResponse, T> errorResponseConsumer) {
        if (isSuccess()) {
            return successConsumer.apply(value);
        } else {
            return errorResponseConsumer.apply(errorResponse);
        }
    }

    /**
     * For handling response values.
     *
     * @param errorResponseConsumer called if there is an error response.
     * @return On success, return the success result, otherwise calls the error handler and returns
     *         the value it generates.
     */
    public T handleError(final Function<ErrorResponse, T> errorResponseConsumer) {
        if (isSuccess()) {
            return value;
        } else {
            return errorResponseConsumer.apply(errorResponse);
        }
    }

    /**
     * If a success value is present, invoke the specified consumer with the value,
     * otherwise do nothing.
     *
     * @param consumer block to be executed if a value is present
     * @throws NullPointerException if value is present and {@code consumer} is null
     */
    public void ifSuccess(final Consumer<? super T> consumer) {
        if (isSuccess()) {
            consumer.accept(value);
        }
    }

    /**
     * If an error value is present, invoke the specified consumer with the error value,
     * otherwise do nothing.
     *
     * @param consumer block to be executed if a value is present
     * @throws NullPointerException if value is present and {@code consumer} is null
     */
    public void ifError(final Consumer<? super ErrorResponse> consumer) {
        if (isFailure()) {
            consumer.accept(getFailure());
        }
    }

    /**
     * If a value is present, returns the value, otherwise throws an exception
     * produced by the exception supplying function.
     *
     * A method reference to the exception constructor with an empty argument
     * list can be used as the supplier. For example,
     * {@code IllegalStateException::new}
     *
     * @param <X> Type of the exception to be thrown
     * @param exceptionSupplier the supplying function that produces an
     *        exception to be thrown
     * @return the value, if present
     * @throws X if no value is present
     * @throws NullPointerException if no value is present and the exception
     *          supplying function is {@code null}
     */
    public <X extends Throwable> T orElseThrow(final Supplier<? extends X> exceptionSupplier) throws X {
        if (value != null) {
            return value;
        } else {
            throw exceptionSupplier.get();
        }
    }

    /**
     * If a value is present, returns the value, otherwise throws an exception
     * produced by the exception supplying function.
     *
     * A method reference to the exception constructor with an empty argument
     * list can be used as the supplier. For example {@code IllegalStateException::new}
     *
     * @param <X> Type of the exception to be thrown
     * @return the value, if present
     * @throws X if no value is present
     * @throws NullPointerException if no value is present and the exception
     *          supplying function is {@code null}
     */
    public <X extends InvalidRequestException> T orElseThrowInvalidRequestException() throws X {
        return orElseThrow(() -> new InvalidRequestException(errorResponse.getMessage(), errorResponse.getCode()));
    }
}
