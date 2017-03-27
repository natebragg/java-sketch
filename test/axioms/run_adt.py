import subprocess
import sys

NUM_TESTS=subprocess.check_output(['find', 'input_adt', '-name', 'm[0-9].sk']).count('\n')
NUM_TRIALS=int(sys.argv[1])

with open('results_adt.csv', 'w') as f: pass
for i in range(NUM_TESTS):
    times = []
    for j in range(NUM_TRIALS):
        print 'test {}, trial {}'.format(i,j)
        nm = 'input_adt/m{}.sk'.format(i)
        cmd = ['sketch', '--slv-seed', '1489670589', '--fe-inc', 'input_adt/', nm]
        print 'cmd:', ' '.join(cmd)
        t = subprocess.check_output(cmd, stderr=subprocess.STDOUT)
        start = t.rfind('Total time = ') + len('Total time = ')
        times.append(float(t[start:t.find('\n', start)]))
    with open('results_adt.csv', 'a') as f:
        [f.write('{:.2f}\t'.format(n)) for n in times]
        f.write('\n')


