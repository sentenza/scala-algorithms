# function to check pangram

def pangram(input):
	
	# convert input string into lower case
	input = input.lower()
	
	# convert input string into Set() so that we will
	# list of all unique characters present in sentence
	input = set(input)

	# separate out all alphabets
	# ord(ch) returns ascii value of character
	alpha = [ ch for ch in input if ord(ch) in range(ord('a'), ord('z')+1)]

	if len(alpha) == 26:
		return 'true'
	else:
		return 'false'

# Driver program
if __name__ == "__main__":
	inpt = input("Enter a string")
	print (pangram(inpt))

