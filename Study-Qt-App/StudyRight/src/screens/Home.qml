import QtQuick 2.0
import QtQuick.Layouts 1.3
import StudyRight 1.0

Rectangle {
    id: root
    width: parent.width
    height: parent.height
    anchors.centerIn: parent
    color: Colors.darkBackground

    ColumnLayout  {
        anchors.centerIn: root
        width: root.width
        height: root.height

        Item {
            id: header
            Layout.alignment: Qt.AlignCenter
            Layout.preferredWidth: root.width * 0.9
            Layout.preferredHeight: root.height * 0.2
            Layout.minimumHeight: root.height * 0.2

            Rectangle {
                id: headerBackground
                radius: 10
                width: header.width
                height: header.height
                anchors.centerIn: header
                color: Colors.midBackground
            }

            HeaderMainText {
                id: headerMainText
                y: 0
                width: header.width
                height: header.height * 0.75
                text: "Welcome to the Study Right Application!!"
            }

            HeaderSubText {
                id: headerSubText
                y: headerMainText.height
                width: header.width
                height: header.height * 0.25
                text: "NOTE: This is currently under development"
            }
        }

        Item {
            id: body
            Layout.alignment: Qt.AlignCenter
            Layout.preferredWidth: root.width * 0.9
            Layout.preferredHeight: root.width * 0.65
            Layout.fillHeight: true

            Rectangle {
                id: bodyBackground
                radius: 20
                width: body.width
                height: body.height
                anchors.centerIn: body
                color: Colors.lightBackground
            }

            GridLayout {
                id: btnGrid
                columns: 2
                anchors.centerIn: body
                width: body.width
                height: body.height

                MenuButton {
                    id: btn1
                    btnText: "<TESTING 1>"
                    Layout.preferredWidth: 400
                    Layout.preferredHeight: 150
                    Layout.alignment: Qt.AlignHCenter
                }
                MenuButton {
                    id: btn2
                    btnText: "<TESTING 2>"
                    Layout.preferredWidth: 400
                    Layout.preferredHeight: 150
                    Layout.alignment: Qt.AlignHCenter
                }
                MenuButton {
                    id: btn3
                    btnText: "<TESTING 3>"
                    Layout.preferredWidth: 400
                    Layout.preferredHeight: 150
                    Layout.alignment: Qt.AlignHCenter
                }
                MenuButton {
                    id: btn4
                    btnText: "<TESTING 4>"
                    Layout.preferredWidth: 400
                    Layout.preferredHeight: 150
                    Layout.alignment: Qt.AlignHCenter
                }

            }
        }



        Item {
            id: footer
            Layout.alignment: Qt.AlignCenter
            Layout.preferredWidth: root.width * 0.9
            Layout.preferredHeight: root.height * 0.1
            Layout.minimumHeight: root.height * 0.1

            Rectangle {
                id: footerBackground
                radius: 10
                width: footer.width
                height: footer.height
                anchors.centerIn: footer
                color: Colors.midBackground
            }
        }
    }


}
