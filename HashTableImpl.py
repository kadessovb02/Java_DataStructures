#!/usr/bin/env python
# coding: utf-8

# In[1]:


class HashTable ():
  
  def __init__ (self):
    self.size = 10
    self.keys = [None]* self.size
    self.values = [None]*self.size
  
  def put (self, key, data):
    index = self.hashfunction(key)  # not None -> it is a collision
    i = 0
    while self.keys[index] is not None:
        index = index+(2**i)%self.size  # rehash to try to find another slot
        i=i+1
    #insert
    self.keys[index] = key
    self.values[index] = data
  
  def get (self, key):
    index = self.hashfunction(key) 
    i = 0
    while self.keys[index] is not None:
        if self.keys[index] == key:
            return self.values [index]
        index = index+(2**i)%self.size  # rehash to try to find another slot
        i=i+1
    return None

  def modify(self, key, newValue):
    index = self.hashfunction(key) 
    i = 0
    while self.keys[index] is not None:
        if self.keys[index] == key:
            self.values[index] = newValue
            break
        index = index+(2**i)%self.size  # rehash to try to find another slot
        i=i+1
        
  def remove(self, key):
    index = self.hashfunction(key) 
    i = 0
    while self.keys[index] is not None:
        if self.keys[index] == key:
            self.values.pop(index)
            self.keys.pop(index) 
            break
        index = index+(2**i)%self.size  # rehash to try to find another slot
        i=i+1
  
  def hashfunction (self, key):  #key in any type
    sum = 0
    for i in key:
        sum = sum + ord(i)
    return sum%self.size


# In[2]:


if __name__ == "__main__":

  table = HashTable()

  table.put("apple", 10)
  table.put("orange", 20)
  table.put("car", 30)
  table.put("table", 40)
  print(table.get("apple"))
  table.modify("apple", 12)
  print(table.get("apple"))
  table.remove("apple")
  print(table.get("apple"))


# In[3]:


dict = {'Joe': 14, 'Adam':26, 'Emely':56}

print (dict['Joe'])

dict['Joe'] = 15
''
print (dict['Joe'])

dict.clear() # delete all items in the dictionary
del dict # delete the dictionary itself


# In[ ]:




