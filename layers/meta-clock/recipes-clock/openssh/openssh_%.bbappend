DESCRIPTION = "Install my authorized SSH keys  and a banner (shown on ssh login) to the image"
LICENSE="CLOSED"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI += " file://authorized_keys file://banner file://sshd_config"

do_install:append () {
    install -d ${D}/home/root/.ssh
    install -p ${WORKDIR}/authorized_keys ${D}/home/root/.ssh

    install -d ${D}/etc/ssh
    install -p ${WORKDIR}/banner ${D}/etc/ssh/banner
    install -p ${WORKDIR}/sshd_config ${D}/etc/ssh/sshd_config
}

FILES:${PN} += " /home/root/.ssh/authorized_keys /etc/ssh/banner"

