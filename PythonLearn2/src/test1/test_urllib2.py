'''
Created on 2017��7��30��

@author: load
'''


import urllib
import urllib.request
import re

url = "http://www.baidu.com"

print ('method1')
response1 = urllib.request.urlopen(url)
print response1.
print len(response1.read())