release-setup:
	# see https://docs.github.com/en/packages/guides/configuring-apache-maven-for-use-with-github-packages
	# create ~/.m2/settings.xml
deploy:
	mvn deploy
