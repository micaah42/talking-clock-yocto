#!/bin/sh

set -e
set -x

SSL_PATH="/etc/ssl"

mkdir -p ${SSL_PATH}

openssl req \
    -newkey rsa:2048 -new -nodes -x509  -days 3650 \
    -subj "/C=AT/ST=Denial/L=Springfield/O=Dis/CN=www.micaah42.com" \
    -keyout ${SSL_PATH}/key.pem -out ${SSL_PATH}/cert.pem

echo "Done!"
systemctl disable init-clock.service

