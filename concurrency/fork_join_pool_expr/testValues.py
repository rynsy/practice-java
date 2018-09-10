import csv, subprocess

command = "java FJExperiment"

pLevels = [2**x for x in range(1, 7)]   # Stack-overflow and illegalArgument for 1 1
sThresh = [10**x for x in range(1, 7)]

out_times = open("output_times.csv", "w")
wr = csv.writer(out_times, delimiter=',', quoting=csv.QUOTE_ALL)
out_text = open("output_text.txt", "w")
for p in pLevels:
    exec_times = []
    for s in sThresh:
        args = " " + str(p) + " " + str(s)
        run_this = command + args
        cmd=subprocess.Popen((run_this), shell=True, stdout=subprocess.PIPE)
        for line in cmd.stdout:
            line = str(line)
            out_text.write(line)
            if "Elapsed time:" in line:
                words = line.split(" ")
                exec_times.append(words[-2])
                print( "Runtime(ns) : " + str(words[-2]) )
                print( "Parallelism Level : " + str(p) )
                print( "Sequential Threshold : " + str(s) + "\n" )
    wr.writerow(exec_times)
out_times.close()
out_text.close()
