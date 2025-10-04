SUMMARY = "RPI clock image with video & audio"
HOMEPAGE = "https://github.com/micaah42"


inherit core-image
inherit populate_sdk_qt6
require recipes-core/images/core-image-base.bb


IMAGE_FEATURES:append = "\
    ssh-server-openssh \
    allow-root-login \
    hwcodecs \
    lic-pkgs \
    splash \
"

EXTRA_IMAGE_FEATURES:append = "\
    allow-empty-password \ 
    empty-root-password \
    allow-root-login \
"

QT6 = " \
    qtbase \
    qtmultimedia \
    qtwebsockets \
    qtdeclarative \
    qtvirtualkeyboard \
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

ALSA = " \
    alsa-lib \
    alsa-tools \
    alsa-plugins \
"

PULSEAUDIO = " \
    pulseaudio \
    pulseaudio-server \
    pulseaudio-client-conf-sato \
    pulseaudio-misc \
"

MISC = " \
    htop \
    samba \
    tzdata \
    openssl \
    openssh \
    apache2 \
    rpi-gpio \
    systemd-analyze \
    systemd-bash-completion \
"

IMAGE_INSTALL += " \
    ${QT6} \
    ${ALSA} \
    ${PULSEAUDIO} \
    ${MISC} \
    ${PYTHON} \
    ${MACHINE_EXTRA_RRECOMMENDS} \
    \
    init-clock \
    talking-clock \
"


set_local_timezone() {
    ln -sf /usr/share/zoneinfo/Europe/Vienna ${IMAGE_ROOTFS}/etc/localtime
    echo 'Europe/Vienna' > ${IMAGE_ROOTFS}/etc/timezone
}

ROOTFS_POSTPROCESS_COMMAND += " \
    set_local_timezone ; \
"

TOOLCHAIN_TARGET_TASK:append = "\
    range-v3-dev \
    tabulate-dev \
"