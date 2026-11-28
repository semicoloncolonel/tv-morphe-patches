## [1.1.3](https://github.com/semicoloncolonel/tv-morphe-patches/compare/v1.1.2...v1.1.3) (2026-11-28)


### Bug Fixes

* **Apple TV:** Show release times for evening releases in the Americas ([08140f4](https://github.com/semicoloncolonel/tv-morphe-patches/commit/08140f438a95e2ad7f4e6b43b2123aba41853b54)), closes [#25](https://github.com/semicoloncolonel/tv-morphe-patches/issues/25)
* **ci:** Ask APKPure when Google Play serves an Android TV build older than the pin ([ff115bb](https://github.com/semicoloncolonel/tv-morphe-patches/commit/ff115bb549b0ee39df45ce3037363146227e5f6e))
* **ci:** Check the bundle before a release is pushed, and repair a release that did not finish ([02ec532](https://github.com/semicoloncolonel/tv-morphe-patches/commit/02ec532c1a9900350807b4e393efef55c6e05fa7))
* **ci:** Do not report a phone build from Google Play as an Android TV update ([8a0eca3](https://github.com/semicoloncolonel/tv-morphe-patches/commit/8a0eca32192a6803d4224606f89e039a8ae57c67))
* **ci:** Read TV apps from Morphe CLI 2.3.0 patch lists, and accept prefixed versions in reports ([4e80110](https://github.com/semicoloncolonel/tv-morphe-patches/commit/4e80110b899281614cd1bc845b5fe11bb598789e))
* **ci:** Record YouTube for Android TV's signing certificate ([96b0cd5](https://github.com/semicoloncolonel/tv-morphe-patches/commit/96b0cd5979a4c5d29ae49cbf540f2cdaee5ac7fc))
* **Fox One:** Add Skip splash sound for 1.21.0 ([7b4e2fc](https://github.com/semicoloncolonel/tv-morphe-patches/commit/7b4e2fc6963b7e130b986486e3aeeccac7259fd1)), closes [#23](https://github.com/semicoloncolonel/tv-morphe-patches/issues/23)
* **GmsCore support:** Restore the certificate only where a call takes a String ([835a2e1](https://github.com/semicoloncolonel/tv-morphe-patches/commit/835a2e152a37284b89cee3c689a2f9de756a353e))
* **hbomax:** Write the pin as a version string so the update check can bump it ([686211b](https://github.com/semicoloncolonel/tv-morphe-patches/commit/686211b0a27186e54f68afceba92b57b535a5862))
* **Mask live ad breaks:** Keep the cover from staying up after a short break ([193f002](https://github.com/semicoloncolonel/tv-morphe-patches/commit/193f0021bab2db7185f33958a5ec41c7690c8c10))
* **mlb:** Keep the playlist header when a preroll ad is removed ([3b43745](https://github.com/semicoloncolonel/tv-morphe-patches/commit/3b43745ce743c291504136ba1ba2503f2d018f19))
* **nbcuott:** Find the MPD start tag without a slow pattern ([8e8cbbb](https://github.com/semicoloncolonel/tv-morphe-patches/commit/8e8cbbbd2619158f6be459476dcd9a0025251393))
* Rebuild the WebView request filter when a second patch adds to it ([c4ad8a0](https://github.com/semicoloncolonel/tv-morphe-patches/commit/c4ad8a0b85eeac577872708f4f6dc45f49eb96c3))
* Remove Starz 6.11.0, which was never tested on Android TV ([49c3b9d](https://github.com/semicoloncolonel/tv-morphe-patches/commit/49c3b9d373d65968eb63bfde193b711dbacb55f4))
* Support the Android TV build of Starz 6.12.1 ([7e56c65](https://github.com/semicoloncolonel/tv-morphe-patches/commit/7e56c65b340fcc402010e35bcde1874d533ab60d))
* testing ABC News (Android TV) 11.13.0, Fox Local (Android TV) 2.19.1, HBO Max (Android TV) 22.1.0.82, NBA (Android TV) 1.4.0.20261113201204, NFL (Android TV) 18.29.0 ([a12b135](https://github.com/semicoloncolonel/tv-morphe-patches/commit/a12b1352807384fe99ac83cbb08280542c3727de))
* testing Apple TV (Android TV) 17.0.4 ([8aaaa12](https://github.com/semicoloncolonel/tv-morphe-patches/commit/8aaaa1256a0d46d53afd4f2e795257330c64bb75))
* testing Disney+ (Android TV) 26.21.0+rc3-2026.11.17 ([363d1ce](https://github.com/semicoloncolonel/tv-morphe-patches/commit/363d1ce62d0450798b004b362fda02665c0699dd))
* testing Fox One (Android TV) 1.21.0, HBO Max (Android TV) 22.1.0.82, JustWatch (Android TV) 26.45.4, YouTube TV (Android TV) 8.02.300 ([c735afa](https://github.com/semicoloncolonel/tv-morphe-patches/commit/c735afa83a1ab8c38da737f9e896519fe4a46042))
* testing NFL (Android TV) 18.28.0, Starz (Android TV) 6.12.2, Tubi (Android TV) 10.46.5000 ([6bca25d](https://github.com/semicoloncolonel/tv-morphe-patches/commit/6bca25dd25d792b16689a5d2714d4721c5cbe328))
* testing YouTube TV (Android TV) 8.03.300 ([4dcc364](https://github.com/semicoloncolonel/tv-morphe-patches/commit/4dcc364c69e15429f34d48d9fd20abcfe1178782))
* **The Roku Channel:** Mark the privacy patches experimental ([af5a1c9](https://github.com/semicoloncolonel/tv-morphe-patches/commit/af5a1c92c730165c5a901c5de79d22567151a7d8))
* **yttvshell:** Answer blocked tracking requests with an empty 204 response ([d8a6720](https://github.com/semicoloncolonel/tv-morphe-patches/commit/d8a67209a1f09a8c39da478ff863c6cafc40021d))


### Features

* Add Fandango at Home and Movies Anywhere for Android TV ([441f48b](https://github.com/semicoloncolonel/tv-morphe-patches/commit/441f48b81839a9fea70b28d0489f258f846bea21))
* Add the Android TV builds of eight news apps ([99c634c](https://github.com/semicoloncolonel/tv-morphe-patches/commit/99c634c13badce96193472b7717c07dcbf05810e))
* **msnow:** Add Skip ads for clips and load the public web app ([72cad1c](https://github.com/semicoloncolonel/tv-morphe-patches/commit/72cad1c39d11d054397d544d9613182069bd8cfc))
* **nbcuott:** Skip ads in CNBC and NBC News clips ([b145ac8](https://github.com/semicoloncolonel/tv-morphe-patches/commit/b145ac81ab40457db602151f6f21fdfa2c0e808a))
* Support NBA 1.2.0.20261103221954 for Android TV ([8ee15a5](https://github.com/semicoloncolonel/tv-morphe-patches/commit/8ee15a55bb667b1e02afc710fec0f39fe38ecbe6))
* Support Peacock 7.11.200 for Android TV ([8ef0dd4](https://github.com/semicoloncolonel/tv-morphe-patches/commit/8ef0dd47f1a3558492e1f13f72bf5df28140a856))
* **The Roku Channel:** Add Hide device identifiers and Block analytics & tracking ([042bd86](https://github.com/semicoloncolonel/tv-morphe-patches/commit/042bd86b9641bfacfa863ebc075307a9a61069cf))
* **The Roku Channel:** Add Skip ads and the Pairip license check ([e35b067](https://github.com/semicoloncolonel/tv-morphe-patches/commit/e35b0670a2840522cb71937ca5acaddc6427a29f)), closes [#26](https://github.com/semicoloncolonel/tv-morphe-patches/issues/26)

## [1.1.2](https://github.com/semicoloncolonel/tv-morphe-patches/compare/v1.1.1...v1.1.2) (2026-11-18)

### Bug fixes

- **MLB**: Skip ads no longer breaks a playlist that starts with an ad. Removing that ad also removed the lines that begin the playlist, so the video could not play. An encryption or map change right before an ad break is now kept as well.
- **YouTube TV**: Block tracking now answers each blocked request with an empty response, as intended. Before, the blocked request returned nothing, which could cause errors in the page.


## [1.1.1](https://github.com/semicoloncolonel/tv-morphe-patches/compare/v1.1.0...v1.1.1) (2026-11-18)

### Supported apps

- **Starz**: the Android TV build of 6.12.1 (version code 9511) is now supported. Before, 6.12.1 was listed with the phone build's version code (4519), so Morphe Manager refused the Android TV build and offered the phone build instead. 6.12.0 is still supported.
- **Starz**: 6.11.0 is no longer supported. It was a phone version and was never tested on an Android TV build.
