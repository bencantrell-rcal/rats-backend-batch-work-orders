# rats-backend-batch-work-orders

<App Purpose>

<App Features>

To run:
On the taskbar on the right, under Maven->Lifecycle, double click "clean"
Under Maven->Lifecycle, double click "install"
Navigate to src/main/java/com/rcal/rats-backend-batch-work-orders>/rats-backend-batch-work-ordersApplication
Click the green run button in the rop right

Workflow:
Make code changes
Run a Maven clean+install to verify compilation and run static code analysis
Push changes
Under Cloud Build->History, the build pipeline is automatically triggered. An artifact is created with the tag "latest"
Under Cloud Build->Triggers, manually trigger the deployment to the test cluster. It should pull "latest" by default
Monitor test deployment, verify changes
Create PR to merge with dev branch through GitHub
Prepare for prod release, have rollback artifact ready
Upon completion of the PR, merge with main and manually trigger a prod deployment when ready
Validate changes, rollback if necessary



Link to GitHub Repo: https://github.com/bencantrell-rcal/rats-backend-batch-work-orders
Link to Google Cloud Build: https://console.cloud.google.com/cloud-build/dashboard?project=noble-helper-469522-j1
Link to Google Artifact Registry: needs to be added
Link to Google Kubernetes Engine: https://console.cloud.google.com/kubernetes/list/overview?project=noble-helper-469522-j1&supportedpurview=project