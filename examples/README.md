# How to run tests

Each folder here describes a single end-to-end test case. The input file to the intepreter is defined as `input.fs`. The output from this program (basically just print statements) can be compared to the outputs, defined as `output.txt`.

Some of these tests depend on a mock environment, which contains a sample project for CPSC 427 (Video Game Programming). The environment can be found [here](https://drive.google.com/file/d/1auG3pufsLEwm2l261Ot4uzK--PqlO4GL/view?usp=sharing).

## Automation Script
To run all tests automatically and see a diff-output for failing tests (which must be done after the Team14 folder has been downloaded), you can run the following automation script:
```bash
python3 examples/test.py
```

# Notes:

 - The output hasn't been fully finalized, so I made some guesses as to what the expected output should be. In particular, there may be some discussion on how file names, sizes and timestamps should be defined. It should be fine as long as our actual output is close enough to expected.
 - These test scripts do not evaluate error handling at all. We may need some tests at the unit level to ensure that we aren't doing anything stupid.
