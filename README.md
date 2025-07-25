# AdaptiveLayoutCompose
AdaptiveLayout (Jetpack Compose) <br/>
**Official document:** https://developer.android.com/develop/ui/compose/layouts/adaptive

**Note**: For apps that target Android 16 (API level 36), the system ignores screen orientation, aspect ratio, and app resizablility restrictions to
improve the layout of apps on form factors with smallest width >= 600dp. [See](https://developer.android.com/develop/ui/compose/layouts/adaptive/app-orientation-aspect-ratio-resizability) App orientation, aspect ratio, and resizability.

# Canonical layouts
Canonical layouts are proven, versatile layouts that provide an optimal user experience on a variety of form factors.
The canonical layouts support small screen phones as well as tablets, foldables, and ChromeOS devices. 

## [List-detail](https://developer.android.com/develop/ui/compose/layouts/adaptive/canonical-layouts#list-detail)
<img width="1708" height="854" alt="image" src="https://github.com/user-attachments/assets/0f95c78e-5eca-4600-86e4-61f78cd1f347" />

See Also [Use window size classes](https://developer.android.com/develop/ui/compose/layouts/adaptive/use-window-size-classes?hl=vi)

**Sample:** [List-detail with Compose](https://github.com/android/user-interface-samples/tree/main/CanonicalLayouts/list-detail-compose)

## [Feed](https://developer.android.com/develop/ui/compose/layouts/adaptive/canonical-layouts#feed)
A feed layout arranges equivalent content elements in a configurable grid for quick, convenient viewing of a large amount of content.
Size and position establish relationships among the content elements.
<img width="1708" height="854" alt="image" src="https://github.com/user-attachments/assets/47d3d88a-17b0-4620-887a-1389845837f5" />

**Sample:** [Feed with Compose](https://github.com/android/user-interface-samples/tree/main/CanonicalLayouts/feed-compose)
