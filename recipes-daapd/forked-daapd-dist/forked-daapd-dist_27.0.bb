LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI = "https://github.com/ejurgensen/forked-daapd/releases/download/${PV}/forked-daapd-${PV}.tar.xz \
           file://0001-Disable-creation-of-log-and-run-directories.patch \
           "
SRC_URI[md5sum] = "5bab6ea3ddd59ec8b92e96b08094052f"
SRC_URI[sha256sum] = "04a5ce79971ec34d8283502a16324b02ce647a4eeaf8fde634d077f2ec6ecfc6"

S = "${WORKDIR}/forked-daapd-${PV}"

DEPENDS = "libgcrypt libunistring zlib confuse libmxml sqlite3 libevent json-c libantlr3c ffmpeg avahi libplist libsodium libwebsockets"
RDEPENDS_${PN} += "libgcc"

inherit pkgconfig autotools gettext

EXTRA_OECONF = ""

FILES_${PN} += "${libdir}/forked-daapd/forked-daapd-sqlext.so ${datadir}/forked-daapd/htdocs/* /run"

