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

Window size classes are a set of opinionated viewport breakpoints that help you design, develop, and test responsive/adaptive layouts. The breakpoints balance layout simplicity with the flexibility of optimizing your app for unique cases.

**Sample:** [List-detail with Compose](https://github.com/android/user-interface-samples/tree/main/CanonicalLayouts/list-detail-compose)

## [Feed](https://developer.android.com/develop/ui/compose/layouts/adaptive/canonical-layouts#feed)
A feed layout arranges equivalent content elements in a configurable grid for quick, convenient viewing of a large amount of content.
Size and position establish relationships among the content elements.
<img width="1708" height="854" alt="image" src="https://github.com/user-attachments/assets/47d3d88a-17b0-4620-887a-1389845837f5" />

**Sample:** [Feed with Compose](https://github.com/android/user-interface-samples/tree/main/CanonicalLayouts/feed-compose)

## [Supporting Pane](https://developer.android.com/develop/ui/compose/layouts/adaptive/canonical-layouts#supporting_pane)
Supporting pane layout organizes app content into primary and secondary display areas.

The primary display area occupies the majority of the app window (typically about two thirds) and contains the main content. The secondary display area is a pane that takes up the remainder of the app window and presents content that supports the main content.

Supporting pane layouts work well on expanded-width displays (see Use window size classes) in landscape orientation. Medium- or compact‑width displays support showing both the primary and secondary display areas if the content is adaptable to narrower display spaces, or if the additional content can be initially hidden in a bottom or side sheet accessible by means of a control such as a menu or button.

A supporting pane layout differs from a list‑detail layout in the relationship of the primary and secondary content. Secondary pane content is meaningful only in relation to the primary content; for example, a supporting pane tool window is irrelevant by itself. The supplementary content in the detail pane of a list‑detail layout, however, is meaningful even without the primary content, for example, the description of a product from a product listing.

**Sample:** [Supporting pane with Compose](https://github.com/android/user-interface-samples/tree/main/CanonicalLayouts/supporting-pane-compose)
