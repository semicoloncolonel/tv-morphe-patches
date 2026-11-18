# [1.2.0-dev.4](https://github.com/semicoloncolonel/tv-morphe-patches/compare/v1.2.0-dev.3...v1.2.0-dev.4) (2026-11-18)


### Bug Fixes

* **mlb:** Keep the playlist header when a preroll ad is removed ([3b43745](https://github.com/semicoloncolonel/tv-morphe-patches/commit/3b43745ce743c291504136ba1ba2503f2d018f19))
* **yttvshell:** Answer blocked tracking requests with an empty 204 response ([d8a6720](https://github.com/semicoloncolonel/tv-morphe-patches/commit/d8a67209a1f09a8c39da478ff863c6cafc40021d))

# [1.2.0-dev.3](https://github.com/semicoloncolonel/tv-morphe-patches/compare/v1.2.0-dev.2...v1.2.0-dev.3) (2026-11-18)

### Supported apps

- **Starz**: 6.11.0 is no longer supported. It was a phone version and was never tested on an Android TV build. 6.12.1 (version code 9511) and 6.12.0 are still supported.

# [1.2.0-dev.2](https://github.com/semicoloncolonel/tv-morphe-patches/compare/v1.2.0-dev.1...v1.2.0-dev.2) (2026-11-18)

### Supported apps

- **Starz**: the Android TV build of 6.12.1 (version code 9511) is now supported. Before, 6.12.1 was listed with the phone build's version code (4519), so the Android TV build was refused. 6.12.0 and 6.11.0 are still supported.
- **Peacock**: 7.11.200 is now supported, as an experimental version. 7.10.200 is still supported.
- **NBA**: 1.2.0.20261103221954 is now supported, as an experimental version. 1.1.0.20261026155843 is still supported.

### Update checks

This source now checks its Android TV apps for new versions and opens an "App update" issue for each one, in this repository.

# [1.2.0-dev.1](https://github.com/semicoloncolonel/tv-morphe-patches/compare/v1.1.0...v1.2.0-dev.1) (2026-11-17)

### Built from this repository

This is the first release built from this repository's own source. Until now, the Android TV patches were built from mobile-morphe-patches. The patches, apps, and versions are the same as in 1.1.0-dev.52.

### New

- [What the patches do](https://github.com/semicoloncolonel/tv-morphe-patches/blob/dev/docs/patches.md) lists every patch, its apps, and what it does.
- [Supported apps](https://github.com/semicoloncolonel/tv-morphe-patches/blob/dev/docs/apps.md) and [Known issues](https://github.com/semicoloncolonel/tv-morphe-patches/blob/dev/docs/known-issues.md) are now in this repository.

Starting version 1.2.0, mobile-morphe-patches patches phone apps only, so keep this source in Morphe Manager to receive the Android TV patches.
