LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI = "https://github.com/ejurgensen/forked-daapd/releases/download/${PV}/forked-daapd-${PV}.tar.xz \
           file://0001-Disable-creation-of-log-and-run-directories.patch \
           file://forked-daapd.service \
           "
SRC_URI[md5sum] = "5bab6ea3ddd59ec8b92e96b08094052f"
SRC_URI[sha256sum] = "04a5ce79971ec34d8283502a16324b02ce647a4eeaf8fde634d077f2ec6ecfc6"

S = "${WORKDIR}/forked-daapd-${PV}"

DEPENDS = "libgcrypt libunistring zlib confuse libmxml sqlite3 libevent json-c libantlr3c ffmpeg avahi libplist libsodium libwebsockets"
RDEPENDS_${PN} += "libgcc"

inherit pkgconfig autotools gettext useradd systemd

EXTRA_OECONF = ""

do_install_append() {
    chown -R daapd:daapd ${D}/${localstatedir}/cache/forked-daapd/
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/forked-daapd.service ${D}${systemd_system_unitdir}/forked-daapd.service
}

FILES_${PN} += "${libdir}/forked-daapd/forked-daapd-sqlext.so ${datadir}/forked-daapd/htdocs/* /run ${systemd_system_unitdir}/forked-daapd.service"

USERADD_PACKAGES = "${PN}"
USERADD_PARAM_${PN} = " \
    --system --no-create-home \
    --home ${localstatedir}/cache/forked-daapd \
    --groups audio \
    --user-group daapd"

SYSTEMD_SERVICE_${PN} = "forked-daapd.service"
