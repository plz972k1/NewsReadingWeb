INSERT INTO users (user_id, email, username)
VALUES ("44c96da8-02c6-11ee-be56-0242ac120002", "ductam22003@gmail.com", "ductam293");

INSERT INTO authors (author_id, name, nationality)
VALUES ("5ea35caa-2565-4781-a01a-e9292eeaaf2f", "japper aitjor", "JPAJA");

INSERT INTO posts (post_id, body, created_at, is_bookmarked, is_like, thumbnail, title, updated_at,
                   author_id)
VALUES ("45ea2087-0678-425e-ad96-d57530eb196a", "This is body", DATE("2017-06-15"), true, true,
        "https://picsum.photos/900",
        "This is title",
        DATE("2017-06-15"), "5ea35caa-2565-4781-a01a-e9292eeaaf2f");


INSERT INTO comments (comment_id, content, created_at, post_id, user_id)
VALUES ("dee9557b-506a-4a35-ab0d-dc7dd5547426", "this is comment", DATE("2017-06-15"),
        "45ea2087-0678-425e-ad96-d57530eb196a",
        "44c96da8-02c6-11ee-be56-0242ac120002")

