pragma Singleton
import QtQuick 2.0

QtObject {
    id: root

    // Background Colors
    readonly property color darkBackground: "#1E2934"
    readonly property color midBackground: "#4A6682"
    readonly property color lightBackground: "#BECCDA"
    // the following 4 need to define actual colors for...
    readonly property color rightBackground: lightBackground
    readonly property color rightBorder: rightText
    readonly property color wrongBackground: darkBackground
    readonly property color wrongBorder: wrongText

    // Text Colors
    readonly property color darkText: "#3A3939"
    readonly property color lightText: "#C3C1C1"
    readonly property color rightText: "#B6CA53"
    readonly property color wrongText: "#B34246"
}
