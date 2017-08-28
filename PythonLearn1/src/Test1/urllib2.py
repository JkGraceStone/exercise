'''
Created on 2017Äê7ÔÂ30ÈÕ

@author: load
'''


import urllib

url = "http://www.baidu.com"

print 'method1'
response1 = urllib.request.urlopen(url)
print response1.getcode()
print len(response1.read())