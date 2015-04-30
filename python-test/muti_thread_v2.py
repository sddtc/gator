#!/usr/bin/python
#-*- coding:utf-8 -*-
from time import ctime, sleep
import threading
from random import choice

def loop(number, sec):
	print("Thread", number, "begins and will sleep", sec, "at", ctime())
	sleep(sec);
	print("Thread", number, "ends at", ctime())
def main():
	seconds=[2, 4]
	threads=[]
	array=range(len(seconds))
	for i in array:
		t=threading.Thread(target=loop, args=(i, choice(seconds)))
		threads.append(t)
	print("main Thread begins at", ctime())
	for t in threads:
		t.start()
	for t in threads:
		t.join()
	print("main Thread ends at", ctime())

if __name__=="__main__":
	main()
