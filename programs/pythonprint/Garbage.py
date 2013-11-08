
class Access(): 
	def A(self): 
		print 0
		print 3
		print self.four(4)
		return True
	def four(self, a): 
		print a
		return True

if __name__ == '__main__':
	print Access().A()
	