# Week 1

## Welcome

- Welcome to the course!
- During the course we will deepen our skills in Java programming and learn more general software developer skills, such as version control
- On top of Programming 1 course, we combine knowledge and skills from other courses as well, e.g. by learning about SQL database programming
- In the welcome Moodle message the required skills were mentioned
- If you don't have a passing grade from the Programming 1 course or otherwise good basic Java programming skills, please come to discuss with me after the lesson

## Moodle and material

- The Moodle area has exercise descriptions, but otherwise the material is in GitHub

## Schedule

- We follow weekly schedule consisting of 8 weeks
- Each week has different topics and a set of programming exercises
- We have two weekly sessions. During the first session of the week we cover the theory of the new topics nad the second sessions is more hands-on programming lab session where we work on the exercises
- Note the weekly deadlines!
- Weekly sections describe the topics and the exercises. The exercise descriptions are in Moodle.
- The first weeks exercises must be submitted before the deadline to confirm course participation!

## Assesment

- Assesment is based on points from the weekly exercises and attendance
- At least 50% session attendance is required to pass the course
- The preliminary grade formula can be found in the course material
- Getting 0.5 points out of 5 points a week on average is enough for passing grade

## Week 1 topic

- During this week we will do some recap on the fundamental Java programming topics and cover the purpose and usage of version control
- On top of programming, version control is the most important part of software developers job
- It is also very important for this course because all the exercises are submitted using the version control tool git and the version control platform GitHub
- In later courses you will most likely use version control tools for different purposes, e.g. for team collaboration in project courses

### Recap

- Let's start with some Java programming recap, before discussing more about version control
- You can use any editor during the course
- In the examples, I'll use Eclipse in the first few weeks and have a look at using VSCode later
- We will also have a look how to build and execute Java programs using command-line tools later on
- Weekly session code examples
- Week 1 examples:
  1. Java projects consists of one or more Java file
  2. Java files have usually one class, which have methods
  3. The main method is a special method, which is execute once the Java program is ran
  4. Executing the Java program (main method)
  5. During this course our Java projects will be Gradle projects
  6. We can spot a Gradle project by the `build.gradle` file, which contains project specific configurations
  7. Gradle is a Java build tool, which is required in more complicated projects having e.g. external libraries as dependencies
  8. Build tools offer features such as building, dependency installation, packaging (JAR executable), and testing of the application
  9. Gradle offers a command-line interface for these operations, which you can try in the exercises
  10. The command-line interface is important for e.g. autmation of the mentioned tasks
  11. Other quite commonly used Java build tool is Maven, which you'll probably face in later studies
  12. In the first week you'll need to know the basics of variables, control structures (`if` statement), loops (`for` and `while` loops), lists, arrays, string handling and objects (e.g. defining your own class)
  13. Go through examples in the main method

### Version control

- The purpose of version control is to tracks changes in code, documents, or projects over time
- It allows multiple people to collaborate in the same codebase without overwriting each other's work
- Version control helps maintain a history of modifications for debugging and auditing
- Git is one of most widely used version control tool
- Git has a command-line interface and many different graphical user interfaces
- We will be using the command-line interfaces, which is basically a must-know tool for a software developer
- Any folder consisting of files can be a git project, which is called a repository
- The local version of the repository is linked to a remote version of the repository, commonly hosted in some cloud-based service such as GitHub
- The purpose of GitHub and similar services is to host repositories to allow publishing code and collaboration
- We constantly "sync" our local repository with the remote repository
- Syncing doesn't happen automatically, but we have full control on the changes we want to publish
- Usually we first create a repository in GitHub. Then we _clone_ it on our computer using a git command-line tool, e.g. Git Bash
- Cloning will create a link between the remote GitHub repository and our local repository
- The basic workflow of making changes is the following:
  1. We _add_ files we have changed (or added) to a new _commit_ (`git add`). Commit represents a group of changes, which is added to the commit history
  2. We _create a commit_ and give it a message describing the changes `git commit -m`. The message will be visible in the commit history
  3. We _push_ the changes to the remote GitHub repository

### Exercises

- Exercises are submitted to GitHub using the git version control tool
- The exercise descriptions are in Moodle
- Exercises contains links to GitHub Classroom service which createas exercise repositories for you
- There are three exercises in the first week, which you can find in Moodle
- Do the exercises in the order listed in Moodle!
- First exercise is about setup
- Second exercise about basic git commands
- The third exercise has some Java programming recap
- Exercises are graded automatically. The Git "Hello world" exercise description in Moodle provies detailed instructions on how to see your points
