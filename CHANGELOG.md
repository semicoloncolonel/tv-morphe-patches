# [1.2.0-dev.13](https://github.com/semicoloncolonel/tv-morphe-patches/compare/v1.2.0-dev.12...v1.2.0-dev.13) (2026-11-19)


### Bug Fixes

* **plex:** Accept both Plex 2026.23.0 builds ([1d1c342](https://github.com/semicoloncolonel/tv-morphe-patches/commit/1d1c34203795a25fe5148752ba0e0eaffadcc95b))

# [1.2.0-dev.12](https://github.com/semicoloncolonel/tv-morphe-patches/compare/v1.2.0-dev.11...v1.2.0-dev.12) (2026-11-19)


### Bug Fixes

* Support Plex 2026.23.0 ([efad441](https://github.com/semicoloncolonel/tv-morphe-patches/commit/efad441171573a26b5cb00376937f2fd2e01a65b))

# [1.2.0-dev.11](https://github.com/semicoloncolonel/tv-morphe-patches/compare/v1.2.0-dev.10...v1.2.0-dev.11) (2026-11-18)


### Bug Fixes

* **ci:** Check the bundle before a release is pushed, and repair a release that did not finish ([02ec532](https://github.com/semicoloncolonel/tv-morphe-patches/commit/02ec532c1a9900350807b4e393efef55c6e05fa7))

# [1.2.0-dev.10](https://github.com/semicoloncolonel/tv-morphe-patches/compare/v1.2.0-dev.9...v1.2.0-dev.10) (2026-11-18)


### Bug Fixes

* **ci:** Do not report a phone build from Google Play as an Android TV update ([8a0eca3](https://github.com/semicoloncolonel/tv-morphe-patches/commit/8a0eca32192a6803d4224606f89e039a8ae57c67))

# [1.2.0-dev.9](https://github.com/semicoloncolonel/tv-morphe-patches/compare/v1.2.0-dev.8...v1.2.0-dev.9) (2026-11-18)


### Bug Fixes

* **ci:** Ask APKPure when Google Play serves an Android TV build older than the pin ([ff115bb](https://github.com/semicoloncolonel/tv-morphe-patches/commit/ff115bb549b0ee39df45ce3037363146227e5f6e))
* **ci:** Record YouTube for Android TV's signing certificate ([96b0cd5](https://github.com/semicoloncolonel/tv-morphe-patches/commit/96b0cd5979a4c5d29ae49cbf540f2cdaee5ac7fc))

# [1.2.0-dev.8](https://github.com/semicoloncolonel/tv-morphe-patches/compare/v1.2.0-dev.7...v1.2.0-dev.8) (2026-11-18)


### Bug Fixes

* **hbomax:** Write the pin as a version string so the update check can bump it ([686211b](https://github.com/semicoloncolonel/tv-morphe-patches/commit/686211b0a27186e54f68afceba92b57b535a5862))

# [1.2.0-dev.7](https://github.com/semicoloncolonel/tv-morphe-patches/compare/v1.2.0-dev.6...v1.2.0-dev.7) (2026-11-18)


### Bug Fixes

* testing NFL (Android TV) 18.28.0, Starz (Android TV) 6.12.2, Tubi (Android TV) 10.46.5000 ([6bca25d](https://github.com/semicoloncolonel/tv-morphe-patches/commit/6bca25dd25d792b16689a5d2714d4721c5cbe328))

# [1.2.0-dev.6](https://github.com/semicoloncolonel/tv-morphe-patches/compare/v1.2.0-dev.5...v1.2.0-dev.6) (2026-11-18)


### Bug Fixes

* Rebuild the WebView request filter when a second patch adds to it ([c4ad8a0](https://github.com/semicoloncolonel/tv-morphe-patches/commit/c4ad8a0b85eeac577872708f4f6dc45f49eb96c3))


### Features

* **msnow:** Add Skip ads for clips and load the public web app ([72cad1c](https://github.com/semicoloncolonel/tv-morphe-patches/commit/72cad1c39d11d054397d544d9613182069bd8cfc))
* **nbcuott:** Skip ads in CNBC and NBC News clips ([b145ac8](https://github.com/semicoloncolonel/tv-morphe-patches/commit/b145ac81ab40457db602151f6f21fdfa2c0e808a))

# [1.2.0-dev.5](https://github.com/semicoloncolonel/tv-morphe-patches/compare/v1.2.0-dev.4...v1.2.0-dev.5) (2026-11-18)


### Features

* Add Fandango at Home and Movies Anywhere for Android TV ([441f48b](https://github.com/semicoloncolonel/tv-morphe-patches/commit/441f48b81839a9fea70b28d0489f258f846bea21))
* Add the Android TV builds of eight news apps ([99c634c](https://github.com/semicoloncolonel/tv-morphe-patches/commit/99c634c13badce96193472b7717c07dcbf05810e))

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
