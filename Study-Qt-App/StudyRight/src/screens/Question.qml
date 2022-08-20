import QtQuick 2.0
import QtQuick.Layouts 1.0
import StudyRight 1.0

Rectangle {
    id: root
    width: parent.width
    height: parent.height
    anchors.centerIn: parent
    color: Colors.darkBackground

    signal flipBtnClicked

    ColumnLayout {
        id: layout
        anchors.centerIn: root
        width: root.width
        height: root.height

        Item {
            id: question
            Layout.alignment: Qt.AlignCenter
            Layout.preferredWidth: root.width
            Layout.preferredHeight: root.height * 0.8
            Layout.fillHeight: true

            Rectangle {
                id: questionBackground
                radius: 20
                width: question.width
                height: question.height
                anchors.centerIn: question
                color: Colors.midBackground
            }
        }

        Item {
            id: btnArea
            Layout.alignment: Qt.AlignCenter
            Layout.preferredWidth: root.width
            Layout.preferredHeight: root.height * 0.2

            FlipButton {
                id: btn
                anchors.centerIn: btnArea
                width: 400
                height: 125

                onClicked: { flipBtnClicked() }
            }
        }
    }
}
