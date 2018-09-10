import csv, numpy as np, matplotlib.pyplot as plt
data = []

f=open("output_times.csv", "r")
for row in csv.reader(f):
    for i in range(len(row)):
        row[i] = int(row[i].strip("\""))
    data.append(row)
"""
    In the CSV file, the rows correspond to the parallelism level,
    and the columns correspond to the sequence threshold. 

    We want multiple line graphs, each for a level of parallelism,
    with the y-axis being runtime and the x-axis being the sequence
    threshold
    
    First, let's invert the list so that each row corresponds to
	a sequence threshold
"""
data = [list(x) for x in zip(*data)]
x_ticks = ["10^"+str(x) for x in range(1,7)]
plt.xticks(np.arange(6), x_ticks)
#labels for x-axis

h = []
for i in range(len(data)):
    #creating handles/labels for each line
    h += plt.plot(data[i], label="pLevel = "+str(2**(i+1)))

plt.xlabel('Sequence Threshold')
plt.ylabel('Runtime (ns)')
plt.legend(handles=h)
# plt.show() # uncomment to display graph
plt.savefig('graph.png') #uncomment to save png
