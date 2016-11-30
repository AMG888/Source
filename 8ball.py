from random import randint
randomnumber=randint(0,13)
print("My name is 8 ball")
print("i am designed by")
print("Mark McGrane")
name = input( "What is your question? ")
print ("your question was " + name)
eightballlist=['it is certain','it is decidedly so','Without a doubt',
'yes definitely','you may rely on it','as i see it yes','most likely',
"Dont count on it",'my reply is no','Very doubtful','Ask again later',
'better not tell you','Concentrate and ask again','my sources say no'];
print (eightballlist[randomnumber])
