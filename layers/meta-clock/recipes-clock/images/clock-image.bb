SUMMARY = "RPI clock image with video & audio"
HOMEPAGE = "https://github.com/micaah42"

IMAGE_FEATURES:append = " ssh-server-openssh allow-root-login"

inherit core-image
inherit populate_sdk_qt5
require recipes-extended/images/core-image-full-cmdline.bb

QT5 = " \
    qtbase \
    qtmultimedia \
    qtwebsockets \
    qtquickcontrols2 \
    qtvirtualkeyboard \
    qtgraphicaleffects \
"

WIFI = "\
    iw \
    crda \
    wpa-supplicant \
"

PYTHON = " \
    python3 \
    python3-pip \
    python3-numpy \
    python3-pandas \
    python3-requests \
"

MISC = " \
    tzdata \
    openssl \
    openssh \
    apache2 \
    systemd-analyze \
    systemd-bash-completion \
"

IMAGE_INSTALL += " \
    ${QT5} \
    ${MISC} \
    ${PYTHON} \
    ${MACHINE_EXTRA_RRECOMMENDS} \
    \
    talking-clock \
"


set_local_timezone() {
    ln -sf /usr/share/zoneinfo/Europe/Vienna ${IMAGE_ROOTFS}/etc/localtime
    echo 'Europe/Vienna' > ${IMAGE_ROOTFS}/etc/timezone
}

ROOTFS_POSTPROCESS_COMMAND += " \
    set_local_timezone ; \
"
