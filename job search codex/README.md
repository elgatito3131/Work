# Job Applications — Agents Reference

This folder is the single workspace for all job application assets. Use this reference to keep everything consistent and fast.

## Workflow
1) Intake JD → save raw posting to `job search codex/<Company>/<Role>/jd.md`.
2) Profile Context → create `profile_notes.md` (skills, projects, achievements).
3) Keywords → extract must‑haves/nice‑to‑haves into `keywords.txt`.
4) Resume Plan → draft `resume_plan.md` (headline, bullets with metrics, skills ordering).
5) Cover Letter → generate from `templates/cover_letter_template.md` into `cover_letter.md`.
6) Tracker → append a line to `job search codex/tracker.csv`.
7) Follow‑up → add a brief message in `email.txt` and set `follow_up_date`.

## Directory Structure
- `job search codex/<Company>/<Role>/`
  - `jd.md` — raw JD text/URL
  - `profile_notes.md` — your highlights for this role
  - `keywords.txt` — ATS skills and requirements
  - `resume_plan.md` — tailored resume bullets/plan (not the full resume)
  - `cover_letter.md` — role‑specific letter
  - `email.txt` — outreach/follow‑up drafts (optional)
- `job search codex/templates/cover_letter_template.md` — source template
- `job search codex/tracker.csv` — application log

## Conventions
- Dates: ISO `YYYY-MM-DD`.
- Keep files lightweight and text‑based (MD/TXT/CSV). No PII beyond what you provide.
- Never fabricate experience; if a gap exists, propose adjacent truthful evidence.
- Prefer roles marked “able to obtain Secret” (vs. “active Secret required”) when applicable.

## How to Add a New Application
1) Create folder: `job search codex/<Company>/<Role>/`.
2) Save JD text/URL in `jd.md`.
3) Draft `profile_notes.md` from your resume + transcript.
4) Extract JD keywords into `keywords.txt`.
5) Create `resume_plan.md` with tailored bullets and skills ordering.
6) Generate `cover_letter.md` using the template.
7) Update `job search codex/tracker.csv` with a new row.

## Recommended Target Roles (NoVA/DC)
- Software Engineer I / Associate (Python/C#/C++)
- SDET / QA / Test Engineer I (unit/integration/system testing)
- Systems/Integration Engineer I (validation, deployments, site support)
- Backend/Database Developer I (Oracle/MySQL/PostgreSQL, REST APIs)
- Junior .NET Developer (C#/ASP.NET)

If you need a new template (resume plan, email, etc.), place it in `job search codex/templates/`.
