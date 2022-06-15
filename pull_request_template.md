# Create and Review a PR

## "*Before all, the programming code is communication between developers. Accidentally, it runs on machines."*

***"Any fool can write code that a computer can understand. Good programmers write code that humans can understand."** Refactoring: Improving the Design of Existing Code, Kent Beck*

*This document aims to give clarity on the process for creating a Pull Request.*

*This document must be approved by #product-tech-leads! 
Currently approved: YES*

Pre-grooming process update (update needed here)

### (The idea is still valid but the process has changed →) Do a story hand off!!  When a story is picked up for development, Dev and QA (and PO, if needed) chat about what needs to be done, what tests we have, what tests need to be created, and a general plan of action

In оthеr words - pre-groom and groom the story right! Check out our [How to groom better](https://www.notion.so/How-to-groom-better-0d16af969c544abc9dc6c378d66f516f) document.

1. Check that all unit tests are in good shape
    1. All of them are green
    2. You have unit tests for your new code.  Are all use cases getting covered?
        1. Happy path
        2. Expected exceptions
        3. Edge cases
        4. Unit/Integration/Automation (FTA, API and UI)
2. Do some manual smoke tests. Use debugging if this will make you confident with the code which you are going to propose for PullRequest.
3. Create a PR - There should be 1 Jira story per BRANCH, however there are exceptions.  ALL HELI-XXXXX need to be in the BRANCH NAME.
    1. If your PR is addressing a **failing test in the Pipeline**, make sure that the name of the failing test is in the title and there is **description that explains the reason for the failure and how it has been resolved.**
    2. Make sure the PR name/Branch Name matches the story name (usually *feature/HELI-XXXXX_short_description*)
        1. For features, the pattern is *feature/HELI-XXXXX_short_description*
        2. For bugs, the pattern is *bug/HELI-XXXXX_short_description*
        3. For PSRs, the pattern is *psr/HELI-XXXXX _short_description*
        4. It is important to keep in mind that the feature/bug/psr part of the branch name be lowercase, to avoid case problems that can occur between Windows and MacOS
        
    3. Make sure commit messages follow the standards set here: [https://github.blog/2011-09-06-shiny-new-commit-styles/](https://github.blog/2011-09-06-shiny-new-commit-styles/)
    4. Review this PR by **yourself!** Even if you check every one of your commits. Do it again. Now you have the chance to see the whole picture. From another point of view.
    *Most developers don’t review their own code. They rely on coworkers. Coworkers aren’t your personal QA. You’re responsible for the code quality.*

        
4. Think in a way that your code is a tale. The code should describe itself. 
5. Check for `TODO`s. We should not leave `TODO`s. Take actions for removing them:
    1. Implement something if it's needed
    2. Refactor it
    3. Raise a discussion with the team about them. If the team agrees and there is a clear plan, follow up actions related with these `TODO`s they might stay for a while.
