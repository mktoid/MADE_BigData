import pandas as pd 
data = pd.read_csv('AB_NYC_2019.csv')
print("MEAN:",  data.price.values.mean())
print("VAR:",  data.price.values.var())
