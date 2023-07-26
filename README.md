# sudoku

A Clojure project to create and solve sudoku programs.

## Usage

For this project a postgres database is needed:

```bash
$ docker run  --name my-postgres-container --env POSTGRES_PASSWORD=mysecretpassword -p 5432:5432 --detach postgres
$ docker run -it --rm --link my-postgres-container:postgres postgres psql -h postgres -U postgres
# Inside of psql run then to create the database
$ CREATE TABLE sudoku (id SERIAL PRIMARY KEY, data VARCHAR(255) NOT NULL);
```

```clojure
$ lein run
```

## License

Copyright © 2023 Lucas Goldner & Flora Maushake

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
