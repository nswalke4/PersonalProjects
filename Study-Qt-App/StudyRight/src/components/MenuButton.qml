import QtQuick 2.0
import QtQuick.Controls 2.0
import StudyRight 1.0

Button {
    id: root
    flat: true

    property alias btnText: mbText.text

    background: Rectangle {
        implicitWidth: parent.width
        implicitHeight: parent.height
        radius: 15
        color: Colors.darkBackground
        border.color: Colors.midBackground
        border.width: 5
    }

    MenuButtonText {
        id: mbText
        anchors.centerIn: root
    }

    onHoveredChanged: {
        console.log("NICK - hover = " + root.hovered);
    }

    onClicked: {
        console.log("[ACTION] '" + btnText + "' was clicked");
    }
}
