FROM postgres:9.5.10

ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD rhecruta
ENV POSTGRES_DB rhecruta

COPY scripts.sql /docker-entrypoint-initdb.d/

