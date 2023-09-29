from PyQt5 import QtCore, QtGui, QtWidgets



class Ui_ApsCriptografia(object):
    def setupUi(self, ApsCriptografia):
        ApsCriptografia.setObjectName("ApsCriptografia")
        ApsCriptografia.resize(691, 534)
        self.Entrada_Texto = QtWidgets.QTextEdit(ApsCriptografia)
        self.Entrada_Texto.setGeometry(QtCore.QRect(10, 50, 531, 181))
        font = QtGui.QFont()
        font.setPointSize(11)
        font.setBold(True)
        font.setWeight(75)
        self.Entrada_Texto.setFont(font)
        self.Entrada_Texto.setStyleSheet("color: rgb(0, 0, 127);")
        self.Entrada_Texto.setObjectName("Entrada_Texto")
        self.label = QtWidgets.QLabel(ApsCriptografia)
        self.label.setGeometry(QtCore.QRect(10, 240, 531, 181))
        font = QtGui.QFont()
        font.setPointSize(11)
        font.setBold(True)
        font.setWeight(75)
        self.label.setFont(font)
        self.label.setStyleSheet("background-color: rgb(255, 255, 255);\n"
"color: rgb(0, 0, 127);")
        self.label.setText("")
        self.label.setObjectName("label")
        self.Btn_Crip = QtWidgets.QPushButton(ApsCriptografia)
        self.Btn_Crip.setGeometry(QtCore.QRect(560, 50, 121, 41))
        font = QtGui.QFont()
        font.setBold(True)
        font.setWeight(75)
        self.Btn_Crip.setFont(font)
        self.Btn_Crip.setCursor(QtGui.QCursor(QtCore.Qt.PointingHandCursor))
        self.Btn_Crip.setStyleSheet("color: rgb(0, 0, 127);")
        self.Btn_Crip.setObjectName("Btn_Crip")
        self.Btn_Des = QtWidgets.QPushButton(ApsCriptografia)
        self.Btn_Des.setGeometry(QtCore.QRect(560, 100, 121, 41))
        font = QtGui.QFont()
        font.setBold(True)
        font.setWeight(75)
        self.Btn_Des.setFont(font)
        self.Btn_Des.setCursor(QtGui.QCursor(QtCore.Qt.PointingHandCursor))
        self.Btn_Des.setStyleSheet("color: rgb(255, 255, 255);\n"
"color: rgb(0, 0, 127);")
        self.Btn_Des.setObjectName("Btn_Des")
        self.fundo = QtWidgets.QLabel(ApsCriptografia)
        self.fundo.setGeometry(QtCore.QRect(-30, 0, 1080, 675))
        self.fundo.setText("")
        self.fundo.setPixmap(QtGui.QPixmap("../APS Cripto/criptografia-1080x675.jpg"))
        self.fundo.setObjectName("fundo")
        self.label_2 = QtWidgets.QLabel(ApsCriptografia)
        self.label_2.setGeometry(QtCore.QRect(670, 160, 20, 21))
        self.label_2.setText("")
        self.label_2.setPixmap(QtGui.QPixmap("../20x20.jpg"))
        self.label_2.setObjectName("label_2")
        self.lineEdit = QtWidgets.QLineEdit(ApsCriptografia)
        self.lineEdit.setGeometry(QtCore.QRect(560, 160, 111, 21))
        self.lineEdit.setEchoMode(QtWidgets.QLineEdit.Password)
        self.lineEdit.setObjectName("lineEdit")
        self.label_3 = QtWidgets.QLabel(ApsCriptografia)
        self.label_3.setGeometry(QtCore.QRect(10, 510, 661, 20))
        font = QtGui.QFont()
        font.setBold(True)
        font.setWeight(75)
        self.label_3.setFont(font)
        self.label_3.setStyleSheet("color: rgb(255, 255, 255);")
        self.label_3.setObjectName("label_3")
        self.fundo.raise_()
        self.Entrada_Texto.raise_()
        self.label.raise_()
        self.Btn_Crip.raise_()
        self.Btn_Des.raise_()
        self.label_2.raise_()
        self.lineEdit.raise_()
        self.label_3.raise_()

        #
        #Funções do botão
        #


        self.retranslateUi(ApsCriptografia)
        QtCore.QMetaObject.connectSlotsByName(ApsCriptografia)

    def retranslateUi(self, ApsCriptografia):
        _translate = QtCore.QCoreApplication.translate
        ApsCriptografia.setWindowTitle(_translate("ApsCriptografia", "Criptografia"))
        self.Btn_Crip.setText(_translate("ApsCriptografia", "CRIPTOGRAFAR"))
        self.Btn_Des.setText(_translate("ApsCriptografia", "DESCRIPTOGRAFAR"))
        self.label_3.setText(_translate("ApsCriptografia", "Trabalho APS Unip 2022 Desenvolvido por Bruno Capovilla, Cristian Rodriguez Passos e Gustavo de Almeida"))




if __name__ == "__main__":
    import sys
    app = QtWidgets.QApplication(sys.argv)
    ApsCriptografia = QtWidgets.QWidget()
    ui = Ui_ApsCriptografia()
    ui.setupUi(ApsCriptografia)
    ApsCriptografia.show()
    sys.exit(app.exec_())
