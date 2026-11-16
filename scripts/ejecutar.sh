#!/usr/bin/env bash
# Compila el proyecto con javac (sin Maven) y ejecuta demos.
# Uso:
#   scripts/ejecutar.sh                      -> ejecuta todas las demos
#   scripts/ejecutar.sh observer             -> demos de un patrón
#   scripts/ejecutar.sh observer.solucion    -> una demo concreta
set -euo pipefail
cd "$(dirname "$0")/.."
OUT=target/classes
mkdir -p "$OUT"
find src/main/java -name '*.java' > target/fuentes.txt
javac --release 17 -encoding UTF-8 -d "$OUT" @target/fuentes.txt
FILTRO="${1:-}"
find src/main/java -name Demo.java | sort | while read -r f; do
  clase=$(echo "${f#src/main/java/}" | sed 's#/#.#g; s#\.java$##')
  if [[ -z "$FILTRO" || "$clase" == *".$FILTRO"* ]]; then
    echo "=== $clase"
    java -cp "$OUT" "$clase"
    echo
  fi
done
