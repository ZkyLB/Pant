#!/usr/bin/env bash
./gradlew dist
alias egg="pant"
pant "pant"
java -Dtoken=${PANT_BOT_TOKEN} -jar build/libs/Pant.jar
