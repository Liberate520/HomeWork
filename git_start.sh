#!/bin/bash
set -e

FILE="git_start.log"
if [ -f "$FILE" ]; then
    rm "$FILE"
fi
exec &>"$FILE"

trap 'echo "Произошла ошибка в команде: $COMM, скрипт завершает работу"; exit 1' ERR

echo "$FILE"
date

for COMM in "git pull" "git status"; do
    echo
    echo "*****************************************"
    echo "Выполняется $COMM"
    $COMM
    echo "Команда выполнена успешно"
done
