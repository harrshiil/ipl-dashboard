# IPL Dashboard

### Spring Boot + JPA
### React JS
### Spring Batch (To load data from CSV)
### HSQL (Hyper SQL)

## Spring Batch
https://spring.io/guides/gs/batch-processing/
### Spring Batch will have 3 components
1. Reader (Read CSV)
2. Processor (Process the data)
3. Writer (Write into DB)


#### Series Playlist: https://www.youtube.com/playlist?list=PLqq-6Pq4lTTa8V613TZhGq4o8hSgkMGQ0
#### GitHub Repo: https://github.com/koushikkothagal/ipl-dashboard

Create Frontend via - npx create-react-app frontend

#
Earlier frontend was running on 3000 and backend was running on 8080,

but now we want to run both system on 8080. so we modifed a bulid script in react package.json
that after completing build process all the files should copy to main/resources/public

problem solved. another prob is when we start app from root. react knows where to route
but if we refresh any page in between react does not know.

one way to fix the problem is hash router. by this way you get additional hash as below

http://localhost:8080/#/teams -> after this it will route every request to index.html 