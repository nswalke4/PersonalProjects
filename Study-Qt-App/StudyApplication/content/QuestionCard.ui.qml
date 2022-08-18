

/*
This is a UI file (.ui.qml) that is intended to be edited in Qt Design Studio only.
It is supposed to be strictly declarative and only uses a subset of QML. If you edit
this file manually, you might introduce QML code that is not supported by Qt Design Studio.
Check out https://doc.qt.io/qtcreator/creator-quick-ui-forms.html for details on .ui.qml files.
*/
import QtQuick 2.15
import QtQuick.Controls 2.15

Rectangle {
    id: root
    width: 640
    height: 480
    color: "#1b3c62"
    radius: 60
    property alias flipBtn: flipBtn

    Rectangle {
        id: questionRect
        x: 20
        y: 16
        width: 600
        height: 380
        color: "#768aa1"
        radius: 15

        ScrollView {
            id: questionScrollArea
            x: 0
            y: 0
            width: 600
            height: 380

            Text {
                id: questionText
                x: 0
                y: 0
                width: 600
                height: 380
                color: "#1f2021"
                text: qsTr("Text")
                font.pixelSize: 36
                horizontalAlignment: Text.AlignHCenter
                verticalAlignment: Text.AlignVCenter
            }
        }
    }

    Button {
        id: flipBtn
        x: 210
        y: 408
        width: 220
        height: 60
        text: qsTr("Flip")
        font.styleName: "Bold"
        font.weight: Font.Bold
        font.pointSize: 30
        flat: false
        highlighted: false
    }
}
