# merging test with fancy history renaming

This repository was populated with the following commands:

```
git remote add -f commons git@github.com:opensha/opensha-commons.git
git remote add -f core git@github.com:opensha/opensha-core.git

git merge --allow-unrelated-histories commons/2020_05-initial-merge-test
git merge --allow-unrelated-histories core/2020_05-initial-merge-test

git remote rm commons
git remote rm core
```

Then I redid the directory structure retaining history using [this tool](https://gist.github.com/emiller/6769886):

```
./git-rewrite-history src/org=src/main/java/org
./git-rewrite-history src/scratch=src/main/java/scratch
./git-rewrite-history src/resources=src/main/resources
./git-rewrite-history test=src/test
git push -f
```

Then I updated added/updated the gradle wrapper with:

```
cp ~/workspace/opensha-commons/./gradlew* .
cp -r ~/workspace/opensha-commons/gradle .
./gradlew wrapper --gradle-version=7.0.1 --distribution-type=bin
```
