@echo off

echo.
echo ###############################################################################
echo # Start - %~n0%~x0 (%0)
echo ###############################################################################
echo.

mvn archetype:generate --batch-mode -DarchetypeGroupId=de.fechtelhoff -DarchetypeArtifactId=maven-wicket-template -DarchetypeVersion=1.0-SNAPSHOT -DgroupId=%1 -DartifactId=%2 -Dpackage=%3

echo.
echo ###############################################################################
echo # Ende
echo ###############################################################################
echo.

echo on
