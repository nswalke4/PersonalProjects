

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
    property alias correctBtn: correctBtn
    property alias incorrectBtn: incorrectBtn

    Rectangle {
        id: questionRect
        x: 30
        y: 8
        width: 580
        height: 140
        color: "#768aa1"
        radius: 10

        ScrollView {
            id: questionScrollArea
            x: 0
            y: 0
            width: 580
            height: 140

            Text {
                id: questionText
                x: 0
                y: 0
                width: 580
                height: 140
                color: "#1f2021"
                text: qsTr("Question")
                font.pixelSize: 24
                horizontalAlignment: Text.AlignHCenter
                verticalAlignment: Text.AlignVCenter
            }
        }
    }

    Rectangle {
        id: answerRect
        x: 30
        y: 154
        width: 580
        height: 240
        color: "#8d9eb1"
        radius: 10
        ScrollView {
            id: answerScrollArea
            x: 0
            y: 0
            width: 580
            height: 240
            Text {
                id: answerText
                x: 0
                y: 0
                width: 580
                height: 240
                color: "#1f2021"
                text: qsTr("Answer")
                font.pixelSize: 36
                horizontalAlignment: Text.AlignHCenter
                verticalAlignment: Text.AlignVCenter
            }
        }
    }

    Button {
        id: incorrectBtn
        x: 65
        y: 407
        width: 220
        height: 60
        text: qsTr("Incorrect")
        highlighted: false
        font.pointSize: 30
        font.weight: Font.Bold
        flat: false
        font.styleName: "Bold"
    }

    Button {
        id: correctBtn
        x: 355
        y: 407
        width: 220
        height: 60
        text: qsTr("Correct")
        highlighted: false
        font.pointSize: 30
        font.weight: Font.Bold
        flat: false
        font.styleName: "Bold"
    }
}
