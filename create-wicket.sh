#!/bin/bash

echo
echo "###############################################################################"
echo "# Start - $(basename $0) ($0)"
echo "###############################################################################"
echo

if [ -z "$1" ]
then
  GROUP="de.fechtelhoff"
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
  -DarchetypeArtifactId=maven-wicket-template \
  -DarchetypeVersion=1.0-SNAPSHOT \
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
