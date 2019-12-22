# meta-daapd

__meta-daapd__ is a Yocto layer that contains a recipe for building [forked-daapd](https://ejurgensen.github.io/forked-daapd/).



## Table of Contents

  - Dependencies
  - Adding the meta-daapd layer to your build
  - Misc

### Dependencies

  URI: git://git.yoctoproject.org/poky
  branch: zeus

  URI: git://git.openembedded.org/meta-openembedded
  branch: zeus

### Adding the meta-daapd layer to your build

Add the required layers from `meta-openembedded`:

  - meta-openembedded/meta-oe
  - meta-openembedded/meta-multimedia
  - meta-openembedded/meta-networking

Add this layer to your Yocto environment (`bitbake-layers add-layer meta-daapd`).

### Misc

  - Currently uses the prebuild antlr3 files from the forked-daapd distribution file
  - Builds sqlite3 with `SQLITE_ENABLE_UNLOCK_NOTIFY` enabled
  - Contains recipe to build `confuse` in version 3.2.2
