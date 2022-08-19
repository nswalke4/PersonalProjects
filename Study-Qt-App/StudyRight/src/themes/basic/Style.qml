pragma Singleton
import QtQuick 2.0

QtObject {
    id: root

    property QtObject sizes: QtObject {
        readonly property real base: 24
        readonly property real big: 36
        readonly property real biggest: 56
    }
    readonly property string family: "Helvetica"

    property QtObject align: QtObject {
        readonly property real hCenter: Text.AlignHCenter
        readonly property real left: Text.AlignLeft
        readonly property real right: Text.AlignRight
        readonly property real justify: Text.AlignJustify
        readonly property real vCenter: Text.AlignVCenter
        readonly property real top: Text.AlignTop
        readonly property real bottom: Text.AlignBottom
    }

    readonly property QtObject caps: QtObject {

    }
}
