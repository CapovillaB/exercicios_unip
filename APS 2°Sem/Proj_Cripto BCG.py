from PyQt5 import QtCore, QtGui, QtWidgets
pri_key = []
txtdesc = ""
wktx = []
txtcod = ""
a = []
b = 0
c = []

class Ui_MainWindow(object):
    def setupUi(self, MainWindow):

        # Definições da janela do programa
        MainWindow.setObjectName("B.C.G Cripto")
        MainWindow.setEnabled(True)
        MainWindow.resize(800, 600)
        MainWindow.setMaximumSize(QtCore.QSize(800, 600))
        # Alinhador dos botoes e caixas de Texto
        self.centralwidget = QtWidgets.QWidget(MainWindow)
        self.centralwidget.setObjectName("centralwidget")
        #Fundo de tela e logo do programa
        self.Fundo_Tela = QtWidgets.QLabel(self.centralwidget)
        self.Fundo_Tela.setGeometry(QtCore.QRect(-10, -10, 800, 600))
        self.Fundo_Tela.setText("")
        self.Fundo_Tela.setPixmap(QtGui.QPixmap("../Proj_Aps_Final/800x600 fundo APS.jpg"))
        self.Fundo_Tela.setObjectName("Fundo_Tela")
        #Label de Status do programa
        self.Label_status = QtWidgets.QLabel(self.centralwidget)
        self.Label_status.setGeometry(QtCore.QRect(20, 250, 139, 21))
        self.Label_status.setStyleSheet("color: rgb(0, 255, 0);\n"
"font: 87 12pt \"Segoe UI Black\";")
        self.Label_status.setObjectName("Label_status")
        # Label de senha
        self.label_senha = QtWidgets.QLabel(self.centralwidget)
        self.label_senha.setGeometry(QtCore.QRect(122, 520, 80, 40))
        self.label_senha.setMinimumSize(QtCore.QSize(80, 40))
        self.label_senha.setMaximumSize(QtCore.QSize(80, 40))
        self.label_senha.setSizeIncrement(QtCore.QSize(80, 40))
        self.label_senha.setStyleSheet("color: rgb(0, 255, 0);\n"
"font: 87 14pt \"Segoe UI Black\";")
        self.label_senha.setObjectName("label_senha")
        #Caixa de entrada da senha de 8 digitos
        self.Line_senha = QtWidgets.QLineEdit(self.centralwidget)
        self.Line_senha.setGeometry(QtCore.QRect(208, 520, 150, 40))
        self.Line_senha.setMinimumSize(QtCore.QSize(150, 40))
        self.Line_senha.setMaximumSize(QtCore.QSize(150, 40))
        self.Line_senha.setEchoMode(QtWidgets.QLineEdit.Password)
        self.Line_senha.setObjectName("Line_senha")
        #Botão para descriptografar
        self.Btn_des = QtWidgets.QPushButton(self.centralwidget)
        self.Btn_des.setGeometry(QtCore.QRect(520, 520, 150, 40))
        self.Btn_des.setMinimumSize(QtCore.QSize(150, 40))
        self.Btn_des.setMaximumSize(QtCore.QSize(150, 40))
        self.Btn_des.setCursor(QtGui.QCursor(QtCore.Qt.PointingHandCursor))
        self.Btn_des.setStyleSheet("#Btn_des{\n"
"    background-color: rgb(0, 255, 0);\n"
"    color: rgb(0, 0, 0);\n"
"    font: 87 10pt \"Segoe UI Black\";\n"
"\n"
"}\n"
"\n"
"Btn_des:pressed{\n"
"    \n"
"    color: rgb(0, 0, 0);\n"
"    border-radius:10px;\n"
"    border:3px solid;\n"
"    border-style: outset;\n"
"    border-width: 2px;\n"
"    border-color: green;\n"
"    box-shadow: 10px 5px 5px white;\n"
"    font: 87 10pt \"Segoe UI Black\"\n"
"\n"
"\n"
"}")
        self.Btn_des.setObjectName("Btn_des")
        #Botão para criptografar
        self.Btn_criptografar = QtWidgets.QPushButton(self.centralwidget)
        self.Btn_criptografar.setGeometry(QtCore.QRect(364, 520, 150, 40))
        self.Btn_criptografar.setMinimumSize(QtCore.QSize(150, 40))
        self.Btn_criptografar.setMaximumSize(QtCore.QSize(150, 40))
        self.Btn_criptografar.setCursor(QtGui.QCursor(QtCore.Qt.PointingHandCursor))
        self.Btn_criptografar.setStyleSheet("#Btn_criptografar{\n"
"    background-color: rgb(0, 255, 0);\n"
"    color: rgb(0, 0, 0);\n"
"    font: 87 10pt \"Segoe UI Black\";\n"
"\n"
"}\n"
"\n"
"Btn_criptografar:pressed{\n"
"    \n"
"    color: rgb(0, 0, 0);\n"
"    border-radius:10px;\n"
"    border:3px solid;\n"
"    border-style: outset;\n"
"    border-width: 2px;\n"
"    border-color: green;\n"
"    box-shadow: 10px 5px 5px white;\n"
"    font: 87 10pt \"Segoe UI Black\"\n"
"\n"
"\n"
"}\n"
"\n"
"\n"
"\n"
"")
        self.Btn_criptografar.setObjectName("Btn_criptografar")
        # Caixa de entrada de texto que será criptografado
        self.lineEdit = QtWidgets.QLineEdit(self.centralwidget)
        self.lineEdit.setGeometry(QtCore.QRect(20, 277, 750, 100))
        self.lineEdit.setMinimumSize(QtCore.QSize(750, 100))
        self.lineEdit.setMaximumSize(QtCore.QSize(750, 100))
        self.lineEdit.setStyleSheet("font: 87 10pt \"Segoe UI Black\";")
        self.lineEdit.setInputMethodHints(QtCore.Qt.ImhMultiLine)
        self.lineEdit.setAlignment(QtCore.Qt.AlignLeading|QtCore.Qt.AlignLeft|QtCore.Qt.AlignTop)
        self.lineEdit.setObjectName("lineEdit")
        #Caixa que saira o Texto apo´s ser criptografado ou descriptografado
        self.textEdit = QtWidgets.QTextEdit(self.centralwidget)
        self.textEdit.setGeometry(QtCore.QRect(20, 410, 750, 100))
        self.textEdit.setMaximumSize(QtCore.QSize(750, 100))
        self.textEdit.setSizeIncrement(QtCore.QSize(750, 100))
        self.textEdit.setStyleSheet("font: 87 10pt \"Segoe UI Black\";")
        self.textEdit.setObjectName("textEdit")
        # Nome da caixa de texto
        self.Label_status_2 = QtWidgets.QLabel(self.centralwidget)
        self.Label_status_2.setGeometry(QtCore.QRect(20, 383, 142, 21))
        self.Label_status_2.setStyleSheet("color: rgb(0, 255, 0);\n"
"font: 87 12pt \"Segoe UI Black\";")
        self.Label_status_2.setObjectName("Label_status_2")
        MainWindow.setCentralWidget(self.centralwidget)

        self.retranslateUi(MainWindow)
        QtCore.QMetaObject.connectSlotsByName(MainWindow)

    #Ações botão chamando funções
        self.Btn_criptografar.clicked.connect(self.acao_btn_cript)
        self.Btn_des.clicked.connect(self.acao_btn_desc)
        self.textEdit.setText("Seja bem vindo ao B.C.G Cripto !!! \nO programa vem com uma senha padrão 10101010 para mudar basta alterar na caixa da senha \nLembre-se a senha precisa ser de 8 números ")
        self.Line_senha.setText("10101010")



    def retranslateUi(self, MainWindow):
        _translate = QtCore.QCoreApplication.translate
        MainWindow.setWindowTitle(_translate("MainWindow", "MainWindow"))
        self.Label_status.setText(_translate("MainWindow", "Entrada de Texto:"))
        self.label_senha.setText(_translate("MainWindow", "SENHA"))
        self.Btn_des.setText(_translate("MainWindow", "DESCRIPTOGRAFAR"))
        self.Btn_criptografar.setText(_translate("MainWindow", "CRIPTOGRAFAR"))
        self.Label_status_2.setText(_translate("MainWindow", "Saída Criptografia"))

    #Funções ações botão

    def acao_btn_cript (self):

        pri_key = []
        txtdesc = ""
        wktx = []
        txtcod = ""
        a = []
        b = 0
        c = []

        senha = (self.Line_senha.text())
        txtdesc = self.lineEdit.text()

        while pri_key == [] or len(pri_key) != 8:  # <--garante 8 casas 'cheias' e diferentes de zero. #atribuir a pry_key
            self.textEdit.setText("Digete a senha novamente com 8 digitos numericos")
            pri_key = [int(i) for i in (senha.replace("0", "1"))]  # atribuir ao Input o valor de sennha ex: input(


        wktx = [str(ord(i)).zfill(3) for i in txtdesc]  # de/para ascii do texto

        while len(wktx) % 16 != 0:
            wktx.append("000")

        a = [[wktx[i:i + 4], wktx[i + 4:i + 8], wktx[i + 8:i + 12], wktx[i + 12:i + 16]] for i in
             range(0, len(wktx), 16)]  # corte em matrizes de 16 bytes (128 bits)

        print(a)

        for k in pri_key:
            for i in range(0, len(a)):
                if k < 5:
                    a[i][k - 1].reverse()
                elif k > 4 and k < 9:
                    b = a[i][k - 5][3]
                    a[i][k - 5][3] = a[i][k - 5][0]
                    a[i][k - 5][0] = b
                    b = a[i][k - 5][2]
                    a[i][k - 5][2] = a[i][k - 5][1]
                    a[i][k - 5][1] = b
                else:
                    a[i].reverse()

        for i in range(0, len(a)):
            for j in range(0, 4):
                for k in a[i][j]:
                    txtcod = txtcod + str(k)


        self.textEdit.setText(txtcod)



    def acao_btn_desc (self):
        pri_key = []
        txtdesc = ""
        wktx = []
        txtcod = ""
        a = []
        b = 0
        c = []

        txtdesc = self.lineEdit.text()
        senha = self.Line_senha.text()

        while pri_key == [] or len(pri_key) != 8:  # <--garante quatro casas 'cheias' e diferentes de zero.
            pri_key = [int(i) for i in senha.replace("0", "1")]

        pri_key.reverse()

        wktx = [txtdesc[i:i + 3] for i in range(0, len(txtdesc), 3)]  # de/para ascii do texto
        print(wktx)

        a = [[wktx[i:i + 4], wktx[i + 4:i + 8], wktx[i + 8:i + 12], wktx[i + 12:i + 16]] for i in
             range(0, len(wktx), 16)]  # corte em matrizes de 16 bytes (128 bits)
        print(a)

        for k in pri_key:
            for i in range(0, len(a)):
                if k < 5:
                    a[i][k - 1].reverse()
                elif k > 4 and k < 9:
                    b = a[i][k - 5][3]
                    a[i][k - 5][3] = a[i][k - 5][0]
                    a[i][k - 5][0] = b
                    b = a[i][k - 5][2]
                    a[i][k - 5][2] = a[i][k - 5][1]
                    a[i][k - 5][1] = b
                else:
                    a[i].reverse()

        for i in range(0, len(a)):
            for j in range(0, 4):
                for k in a[i][j]:
                    txtcod = txtcod + chr(int(k))


        self.textEdit.setText(txtcod)



if __name__ == "__main__":
    import sys
    app = QtWidgets.QApplication(sys.argv)
    MainWindow = QtWidgets.QMainWindow()
    ui = Ui_MainWindow()
    ui.setupUi(MainWindow)
    MainWindow.show()
    sys.exit(app.exec_())

