/****************************************************************************
**
** Copyright (C) 2021 The Qt Company Ltd.
** Contact: https://www.qt.io/licensing/
**
** This file is part of Qt Quick Studio Components.
**
** $QT_BEGIN_LICENSE:GPL$
** Commercial License Usage
** Licensees holding valid commercial Qt licenses may use this file in
** accordance with the commercial license agreement provided with the
** Software or, alternatively, in accordance with the terms contained in
** a written agreement between you and The Qt Company. For licensing terms
** and conditions see https://www.qt.io/terms-conditions. For further
** information use the contact form at https://www.qt.io/contact-us.
**
** GNU General Public License Usage
** Alternatively, this file may be used under the terms of the GNU
** General Public License version 3 or (at your option) any later version
** approved by the KDE Free Qt Foundation. The licenses are as published by
** the Free Software Foundation and appearing in the file LICENSE.GPL3
** included in the packaging of this file. Please review the following
** information to ensure the GNU General Public License requirements will
** be met: https://www.gnu.org/licenses/gpl-3.0.html.
**
** $QT_END_LICENSE$
**
****************************************************************************/

import QtQuick
import QtQuick.Window
import StudyApplication

Window {
    width: mainScreen.width
    height: mainScreen.height

    visible: true
    title: "StudyApplication"

    property int scrHOME: 0
    property int scrFCHOME: 1
    property int scrFCQUESTION: 2
    property int scrFCANSWER: 3
    property int scrFCRESULT: 4
    property int scrUNAVAILABLE: 5
    property int scrIMPORT: 6
    property int curScr: scrHOME

    HomeScreen {
        id: mainScreen
        visible: curScr === scrHOME
        anchors.centerIn: parent

        onVisibleChanged: {
            if (this.visible) {
                console.log("  ~SCREENCHANGE~ Home Screen Showing")
            }
        }

        flashcardBtn.onClicked: {
            console.log("[ACTION] flashcardBtn clicked");
            curScr = scrFCQUESTION
        }

        unavailableBtn1.onClicked: {
            console.log("[ACTION] unavailableBtn1 clicked");
        }

        unavailableBtn2.onClicked: {
            console.log("[ACTION] unavailableBtn2 clicked");
        }

        unavailableBtn3.onClicked: {
            console.log("[ACTION] unavailableBtn3 clicked");
        }

        unavailableBtn4.onClicked: {
            console.log("[ACTION] unavailableBtn4 clicked");
        }

        unavailableBtn5.onClicked: {
            console.log("[ACTION] unavailableBtn5 clicked");
        }

        unavailableBtn6.onClicked: {
            console.log("[ACTION] unavailableBtn6 clicked");
        }

        importBtn.onClicked: {
            console.log("[ACTION] importBtn clicked");
        }
    }

    QuestionCard {
        id: fcquestion
        visible: curScr === scrFCQUESTION
        anchors.centerIn: parent

        onVisibleChanged: {
            if (this.visible) {
                console.log("  ~SCREENCHANGE~ FC Question Screen Showing")
            }
        }

        flipBtn.onClicked: {
            console.log("[ACTION] flipBtn clicked");
            curScr = scrFCANSWER
        }

    }

    AnswerCard {
        id: fcanswer
        visible: curScr === scrFCANSWER
        anchors.centerIn: parent

        onVisibleChanged: {
            if (this.visible) {
                console.log("  ~SCREENCHANGE~ FC Answer Screen Showing")
            }
        }

        incorrectBtn.onClicked: {
            console.log("[ACTION] incorrectBtn clicked");
            curScr = scrHOME
        }

        correctBtn.onClicked: {
            console.log("[ACTION] correctBtn clicked");
            curScr = scrFCQUESTION
        }
    }

}

