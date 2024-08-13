#!/bin/bash

echo
echo "###############################################################################"
echo "# Start - $(basename "$0") ($0)"
echo "###############################################################################"
echo

Help()
{
   echo "Usage:"
   echo "  create-wicket-wildfly [options] | <groupId> <artifactId> <packageName>"
   echo
   echo "If you do not specify \"groupId\", \"artifactId\" and \"packageName\" default values will be used."
   echo
   echo "Options:"
   echo "-h --help    Print this Help."
}

case $1 in
  -h | --help) # display Help
     Help
     exit;;
  -*) # Invalid option
     echo "Error: Invalid option"
     exit;;
esac

if [ -z "$1" ]
then
  GROUP="com.example"
else
  GROUP="$1"
fi

if [ -z "$2" ]
then
  ARTIFACT="test"
else
  ARTIFACT="$2"
fi

if [ -z "$3" ]
then
  PACKAGE="${GROUP}.${ARTIFACT}"
else
  PACKAGE="$3"
fi

VERSION="1.0-SNAPSHOT"

echo "Group    = ${GROUP}"
echo "Artifact = ${ARTIFACT}"
echo "Version  = ${VERSION}"
echo "Package  = ${PACKAGE}"
echo

mvn archetype:generate --batch-mode \
  -DarchetypeGroupId=de.fechtelhoff \
  -DarchetypeArtifactId=maven-wicket-wildfly-template \
  -DarchetypeVersion=2.0-SNAPSHOT \
  -DgroupId="${GROUP}" \
  -DartifactId="${ARTIFACT}" \
  -Dversion="${VERSION}" \
  -Dpackage="${PACKAGE}"

echo
echo "###############################################################################"
echo "# Ende"
echo "###############################################################################"
echo

exit
