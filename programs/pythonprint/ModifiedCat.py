
class Cat(): 
	def Meow(self): 
		sys.stdout.write ("You ")
		sys.stdout.write ("have ")
		sys.stdout.write ("cat ")
		sys.stdout.write ("to ")
		sys.stdout.write ("be ")
		sys.stdout.write ("kitten ")
		sys.stdout.write ("me ")
		sys.stdout.write ("right ")
		sys.stdout.write ("meow ")
		return True

import sys
if __name__ == '__main__':
	print Cat().Meow()
	