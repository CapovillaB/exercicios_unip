# Project Cripto v3
# Data : 16/08/2022 ~ /11/2022
# Autores: Bruno Capovilla / Gustavo Miranda / Cristian Rodriguez
# Contato : lagartisha@hotmail.com / 

from math import log
import os
from random import randint
import sqlite3 as sq

## variáveis

cam_cod = ""
cam_desc = ""
modo = 0
cur = ""
con = ""
txtdesc = ""
wktx = []
txtcod = ""
y = 0
x = []
z = []
w = []
arq_crip = ""
arq_desc = ""
nome_arq = ""
dbdados = ""
user_name = ""
pri_key = ""
pub_key = ""

## criacao e conexao com db / criacao do folder para trabalho

try:
    folder = os. getcwd() + '\\Cripto'
    os.makedirs(folder) # criação do folder
except:
    print("Tudo pronto!")

con = sq.connect(folder +'\\logins') # criação do DB se vazio
cur = con.cursor()

cur.execute("CREATE TABLE IF NOT EXISTS logins (user_name TEXT PRIMARY KEY, pub_key TEXT)") # criação da table se DB vazio
con.commit()

#cur.execute("SELECT * FROM logins")
#dbdados = cur.fetchall()                        #<-- para check do DB
#print(dbdados)


## path de cadastro
def cadastro():

    y = 0
    x = []                                                  
    user_name = ""
    pri_key = ""
    pub_key = ""

    while user_name == "" or len(user_name) > 26 and pub_key == "": # entrada de dados de usuario
        user_name = str(input("Entre seu 'username' (25 caracteres no máximo): "))
         
    while pri_key == "" or len(pri_key) != 4: #<--garante quatro casas 'cheias' e diferentes de zero.
        pri_key = input("Entre sua senha (4 dígitos): ").replace("0", "1")
    
    pub_key = str(2**(int(pri_key[2:4])+int(pri_key[0:2]))) # criaçao da chave publica
   
    y = [user_name,pub_key]

    try:
        cur.execute("INSERT INTO logins (user_name,pub_key) VALUES (?,?)",y) # cadastro do usuario no DB
        con.commit()
    except:
        quit("Usuário já cadastrado.")

    quit("Obrigado e até a próxima!")

## path de criptografia
def criptografar():

    cam_cod = ""
    cam_desc = ""
    txtdesc = ""
    wktx = []
    txtcod = ""
    y = ""
    x = ""
    z = []
    arq_crip = ""
    arq_desc = ""
    nome_arq = ""
    user_name = ""
    pub_key = ""

    print("Coloque seu arquivo na pasta 'Cripto' na Área de Trabalho, para que possa ser criptografado!")

    for i in range(0,3):
        user_name = [str(input("Destinatário da mensagem: "))]
        try:
            cur.execute("SELECT pub_key FROM logins WHERE user_name = (?)",user_name)
            pub_key = cur.fetchone()
        except:
            print("Usuário não cadastrado.")
        
        if pub_key != "":
            break
        elif i == 2:
            quit("Por favor use outro 'username'. Obrigado e até a próxima!")

    nome_arq = input("--Dê o nome do arquivo:") + ".txt"
    cam_desc = "".join(folder,'\\', nome_arq)
    with open(cam_desc, "r") as arq_desc: # leitor do arquivo txt
        txtdesc = arq_desc.read()
        arq_desc.close()
    
    wktx = [int(ord(i)) for i in txtdesc] # de/para ascii do texto
    
    pub_key = str(pub_key[0]).split("000") # recuperação da chave pública
    
    for i in range(0,len(wktx)): # criptografia do arquivo
        if i == 0:
            x = randint(1,100) #<-- criação de assinatura eletronica
            y = "000" + str(2**(int(wktx[i]))*(int(pub_key[0])))
            txtcod = str(x) + "000" + str((2**x)*(int(pub_key[0]))) + y
        else:
            txtcod =  txtcod + "000" + str(2**(int(wktx[i]))*(int(pub_key[0])))
    
    nome_arq = input("Qual o nome do arquivo de saída?") + ".txt" # criação do arquivo e gravação do texto criptografado
    cam_cod =  "".join(folder,'\\',nome_arq)
    with open(cam_cod, "x") as arq_crip:
        arq_crip.write(txtcod)
        arq_crip.close()

    quit("Obrigado e até a próxima!","\n","Busque seu arquivo na pasta 'Cripto' na Área de Trabalho!")
    

## path de descriptografia
def descriptografar():
    
    cam_desc = ""
    cam_cod = ""
    txtdesc = ""
    wktx = []
    txtcod = ""
    y = 0
    x = []
    z = []
    arq_crip = ""
    arq_desc = ""
    nome_arq = ""
    pri_key = ""

    nome_arq = input("--Dê o 'path' do arquivo:") + ".txt"
    cam_cod =  "".join(folder,'\\',nome_arq)
    arq_crip = open(cam_cod, "r") # leitor do texto codificado
    txtcod = arq_crip.read()
    arq_crip.close()

    wktx =  txtcod.split("000") # slicing da mansagem criptografada

    print(wktx)
     
    for i in range(0,3): # checagem de segurança / assinatura eletronica 
        pri_key = input("Entre sua senha (4 dígitos): ").replace("0", "1")
        x = 2**(int(pri_key[0:2])+int(pri_key[2:4]))

        print(x)
        
        y = int(log(int(wktx[1])/x,2))

        print(y)

        if y == int(wktx[0]) and i < 2:
            break
        elif i == 2:
            quit("Essa mensagem não é para você!")
    
    txtdesc = ""
    print(wktx)
    for i in range(2, len(wktx)): # descriptografia
        y = chr(int(log(int(wktx[i])/x,2)))
        txtdesc = txtdesc + y
    
    nome_arq=input("Qual o nome do arquivo de saída?") + ".txt" # criação do arquivo e gravação do texto decofificado
    cam_desc =  "".join(folder,'\\',nome_arq)
    with open(cam_desc, "x") as arq_desc:
        arq_desc.write(txtdesc)
        arq_desc.close()

    quit("Obrigado e até a próxima!")



## ihc / menu


print("\033[34m Bem vindo ao Cripto!","\n",
    "Este é um programa de criptográfia de arquivos .txt apenas.","\n",
    "Por favor, indique o modo de operação:","\n",
    "1 - Criptografar","\n","2 - Descriptografar","\n","3 - Cadastro de Usuário","\n",
    "Ou, para sair, qualquer outra tecla.")

modo = input("--Selecione o modo de operação:")
if modo =="1":
    criptografar()

elif modo =="2":
    descriptografar()

elif modo =="3":
    cadastro()

else:
    quit("Obrigado e até a próxima!")