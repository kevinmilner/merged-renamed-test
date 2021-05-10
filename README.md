# merging test with fancy history renaming

This repository was populated with the following commands:

```
git remote add -f commons git@github.com:opensha/opensha-commons.git
git remote add -f core git@github.com:opensha/opensha-core.git

git merge --allow-unrelated-histories commons/2020_05-initial-merge-test
git merge --allow-unrelated-histories core/2020_05-initial-merge-test
```

Then I redid the directory structure with:

```
kevin@steel:~/git/merge_tests/merged-test$ cd src/
kevin@steel:~/git/merge_tests/merged-test/src$ mkdir main
kevin@steel:~/git/merge_tests/merged-test/src$ mkdir main/java
kevin@steel:~/git/merge_tests/merged-test/src$ git mv org/ main/java/
kevin@steel:~/git/merge_tests/merged-test/src$ git mv scratch/ main/java/
kevin@steel:~/git/merge_tests/merged-test/src$ git mv resources/ main/
kevin@steel:~/git/merge_tests/merged-test/src$ git mv ../test/ .


kevin@steel:~/git/merge_tests/merged-renamed-test$ mkdir src/main
kevin@steel:~/git/merge_tests/merged-renamed-test$ mkdir src/main/java
kevin@steel:~/git/merge_tests/merged-renamed-test$ ./git-rewrite-history src/org=src/main/java/org

```

